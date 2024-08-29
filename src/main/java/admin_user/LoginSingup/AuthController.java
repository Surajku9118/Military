package admin_user.LoginSingup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String showIndex() {
        return "index"; // Return the name of the index view (e.g., index.html)
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup"; // Return the name of the signup view (e.g., signup.html)
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Email already exists");
            return "signup";
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/login"; // Redirect to login page after successful registration
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Return the name of the login view (e.g., login.html)
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "about"; // Return the name of the about view (e.g., about.html)
    }

    @GetMapping("/apply")
    public String showApplyPage() {
        return "apply"; // Return the name of the apply view (e.g., apply.html)
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact"; // Return the name of the contact view (e.g., contact.html)
    }

    @GetMapping("/donate")
    public String showDonatePage() {
        return "donate"; // Return the name of the donate view (e.g., donate.html)
    }

    @GetMapping("/help")
    public String showHelpPage() {
        return "help"; // Return the name of the help view (e.g., help.html)
    }

    @GetMapping("/memorials")
    public String showMemorialsPage() {
        return "memorials"; // Return the name of the memorials view (e.g., memorials.html)
    }

    @GetMapping("/resources")
    public String showResourcesPage() {
        return "resources"; // Return the name of the resources view (e.g., resources.html)
    }

    @GetMapping("/volunteer")
    public String showVolunteerPage() {
        return "volunteer"; // Return the name of the volunteer view (e.g., volunteer.html)
    }
    
    @GetMapping("/volunteerapply")
    public String showvolunteerapplyPage() {
        return "volunteerapply"; // Return the name of the volunteer view (e.g., volunteer.html)
    }
}
