package tr.edu.ogu.ceng.notification.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import tr.edu.ogu.ceng.notification.entity.User;
import tr.edu.ogu.ceng.notification.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class UserService {

    private UserRepo userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {

        User user = getUserById(id);

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setCreatedAt(userDetails.getCreatedAt());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = getUserById(id); // Ensure user exists
        userRepository.delete(user);
    }
}
