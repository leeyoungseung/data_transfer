package data_transfer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import data_transfer.model.Member;
import data_transfer.model.MemberListBean;


@Controller
public class DataTransferController {

	@RequestMapping(value = "/parameter/{id}/{num}", method = RequestMethod.GET)
	public String checkingStringIntParameter(
			@PathVariable String id
			,@PathVariable int num
			,Model model) {
		
		model.addAttribute("checked_id","id : [ "+id+ " ] number : [ "+ num +" ]" );
		return "01_checkParam";
	}
	
	@RequestMapping(value = "/parameter", method = RequestMethod.GET)
	public String checkingStringIntParameter2(
			@RequestParam String id
			,@RequestParam int num
			,Model model) {
		
		model.addAttribute("checked_id","id : ["+ id +" ] number : [ "+ num +" ]" );
		return "02_checkParam";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String checkingForm() {
		
		return "03_checkFrom";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String checkingForm(
			@RequestParam String email
			,@RequestParam String age
			,Model model) {
		
		model.addAttribute("email",email);
		model.addAttribute("age",""+age);
		return "03_checkFromRes";
	}
	
	@RequestMapping(value = "/formBean", method = RequestMethod.GET)
	public String checkingForm2(Model model) {
		model.addAttribute("member", new Member());
		return "04_checkFrom";
	}
	
	@RequestMapping(value = "/formBean", method = RequestMethod.POST)
	public String checkingForm2(
			@Valid Member memberBean
			,BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "redirect:/app/formBean";
		}
		memberBean.setJoined(new Date());
		model.addAttribute("member",memberBean);
		return "04_checkFromRes";
	}
	
	@RequestMapping(value = "/formListBean", method = RequestMethod.GET)
	public String checkingListForm(Model model) {
		Member m1 = new Member();
		Member m2 = new Member();
		Member m3 = new Member();
		List<Member> beanList = new ArrayList<Member>();
		beanList.add(m1);
		beanList.add(m2);
		beanList.add(m3);
		
		//model.addAttribute("list",beanList);
		MemberListBean mb = new MemberListBean();
		mb.setList(beanList);
		model.addAttribute("memBean",mb);
		
		return "05_checkListFrom";
	}
	
	@RequestMapping(value = "/formListBean", method = RequestMethod.POST)
	public String checkingListForm(@ModelAttribute(value = "memBean") MemberListBean memBean
			,Model model) {
		List<Member> tempList = memBean.getList();
		for (Member member : tempList) {
			System.out.println(member.getId());
			System.out.println(member.getName());
			member.setJoined(new Date());
			System.out.println(member.getJoined());
		}
		
		
		model.addAttribute("memberList",tempList);
		return "05_checkListFromRes";
	}
}
