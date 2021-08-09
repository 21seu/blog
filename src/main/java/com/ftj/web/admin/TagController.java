package com.ftj.web.admin;

import com.ftj.pojo.Tag;
import com.ftj.pojo.Type;
import com.ftj.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by fengtj on 2021/8/7 19:07
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TagService tagService;

    /**
     * 拿到标签数据且渲染标签主页
     *
     * @param pageable
     * @param model
     * @return
     */
    @RequestMapping("/tags")
    public String tagPage(@PageableDefault(sort = {"id"}) Pageable pageable, Model model) {
        Page<Tag> page = tagService.listTags(pageable);
        model.addAttribute("page", page);
        LOGGER.info("page {}", page);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

    @PostMapping("/tags")
    public String input(@Valid Tag tag, BindingResult result, RedirectAttributes attributes) {
        Tag t1 = tagService.getTagByName(tag.getName());
        if (t1 != null) result.rejectValue("name", "nameError", "不能添加重复的标签");
        if (result.hasErrors()) return "admin/tags-input";
        Tag t = tagService.saveTag(tag);
        if (t == null) {
            attributes.addFlashAttribute("message", "添加失败");
        } else {
            attributes.addFlashAttribute("message", "添加成功");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    public String editPost(@Valid Tag tag, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        Tag t1 = tagService.getTagByName(tag.getName());
        if (t1 != null) {
            result.rejectValue("name", "nameError", "不能添加重复的标签");
        }
        if (result.hasErrors()) return "admin/tags-input";
        Tag t = tagService.updateType(id, tag);
        if (t == null) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        LOGGER.info("id:{},tag:{}", id, tagService.getTag(id));
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/tags";
    }


}
