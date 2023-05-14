package AlgoritmicBlog.AlgoritmicBlog.Controllers;

import AlgoritmicBlog.AlgoritmicBlog.BD.Post;
import AlgoritmicBlog.AlgoritmicBlog.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    /*@PostMapping("/blog")
    public String createPost(@RequestParam String title,
                             @RequestParam String anons,
                             @RequestParam String fullText,
                             @RequestParam String tag) {
        postService.createPost(title, anons, fullText, tag);
        return "redirect:/blog";
    }*/
    @GetMapping("/blog")
    public String blog(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",  posts);
        return "blog-all";
    }
    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }
    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String fullText,
                              Model model){
        Post post = new Post(title,anons,fullText);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{post_id}")
    public String blogRead(@PathVariable(value = "post_id") long postId, Model model) {
        if (!postRepository.existsById(postId)){
            return "redirect:/blog";
        }
        Optional<Post> post=postRepository.findById(postId);
        ArrayList<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("post",result);
        return "blog-read";
    }

    @GetMapping("/blog/{post_id}/edit")
    public String blogEdit(@PathVariable(value = "post_id") long postId, Model model) {
        if (!postRepository.existsById(postId)){
            return "redirect:/blog";
        }
        Optional<Post> post=postRepository.findById(postId);
        ArrayList<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("post",result);
        return "blog-edit";
    }

    @PostMapping("/blog/{post_id}/edit")
    public String blogPostEdit(@PathVariable(value = "post_id") long postId,
                               @RequestParam String title,
                               @RequestParam String anons,
                               @RequestParam String fullText,
                               Model model){
        Post post = postRepository.findById(postId).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(fullText);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{post_id}/delete")
    public String blogPostDelete(@PathVariable(value = "post_id") long postId,
                               Model model){
        Post post = postRepository.findById(postId).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }
}
