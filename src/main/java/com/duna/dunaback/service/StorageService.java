package com.duna.dunaback.service;

import com.duna.dunaback.entities.AvatarData;
import com.duna.dunaback.entities.FileData;
import com.duna.dunaback.enums.AdvertType;
import com.duna.dunaback.repositories.AvatarDataRepo;
import com.duna.dunaback.repositories.FileDataRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StorageService {

    private final FileDataRepo dataRepo;

    private final AvatarDataRepo avatarDataRepo;

    @Value("${app-settings.folder-name}")
    private String FOLDER_PATH;
    //test------------
    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        FileData fileData = uploadFileToFS(file, null);

        return "file uploaded successfully : " + FOLDER_PATH + fileData.getName();
    }
    //test---------------

    public FileData uploadFileToFS(MultipartFile file, Long orderId) throws IOException {
        if (file.isEmpty())
            throw new FileNotFoundException("File not found");
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFilename = UUID.randomUUID() + "." + extension;
        String filePath = FOLDER_PATH + newFilename;

        FileData fileData = dataRepo.save(new FileData(
                orderId,
                newFilename,
                file.getContentType(),
                filePath));

        file.transferTo(new File(filePath));
        return fileData;
    }

    public AvatarData uploadAvatarToFS(MultipartFile file, Long userId) throws IOException {
        if(file.isEmpty())
            throw new FileNotFoundException("File not found");
        deletePreviousAvatar(userId);
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID() + "." + extension;
        String filePath = FOLDER_PATH + newFileName;

        AvatarData avatarData = avatarDataRepo.save(new AvatarData(
                userId,
                newFileName,
                file.getContentType(),
                filePath
        ));

        file.transferTo(new File(filePath));
        return avatarData;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        FileData fileData = findByNameOrException(fileName);
        String filePath=fileData.getFilePath();
        return Files.readAllBytes(new File(filePath).toPath());
    }

    public byte[] downloadAvatarFromFS(Long userId) throws IOException {
        AvatarData avatarData = findByUserIdOrException(userId);
        String filePath = avatarData.getFilePath();
        return Files.readAllBytes(new File(filePath).toPath());
    }

    public FileData findByNameOrException(String fileName) {
        return dataRepo.findByName(fileName).orElseThrow(() -> new EntityNotFoundException("File not found"));
    }

    private AvatarData findByUserIdOrException(Long userId) {
        return avatarDataRepo.findByUserId(userId).orElseThrow(() -> new EntityNotFoundException("FIle not found"));
    }

    public List<String> findAllImageNamesByOrderId(Long orderId, AdvertType advertType) {
        List<String> orderNames = dataRepo.findAllByOrderIdAndAdvertType(orderId, advertType).stream().map(FileData::getName).collect(Collectors.toList());
        return orderNames;
    }

    public void deletePreviousAvatar(Long userId) throws IOException {
        if(avatarDataRepo.findByUserId(userId).isPresent()) {
            AvatarData avatarData = findByUserIdOrException(userId);
            avatarDataRepo.removeByUserId(userId);
            Files.delete(Paths.get(avatarData.getFilePath()));
        }
    }

}
