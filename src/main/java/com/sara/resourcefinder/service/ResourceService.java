package com.sara.resourcefinder.service;

import com.sara.resourcefinder.model.Resource;
import com.sara.resourcefinder.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Optional<Resource> getResourceById(Long id) {
        return resourceRepository.findById(id);
    }

    public Resource saveResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

    public List<Resource> getResourcesByCategory(String category) {
        return resourceRepository.findByCategory(category);
    }

    public List<Resource> getResourcesByLocation(String location) {
        return resourceRepository.findByLocation(location);
    }

    public List<Resource> getResourcesByStatus(String status) {
        return resourceRepository.findByStatus(status);
    }
}
