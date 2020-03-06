package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ClassRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;

@SpringBootApplication
public class StudentmgmtappApplication implements CommandLineRunner {
	
	@Autowired
	private StudentMgmtApp app;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private TranscriptRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StudentmgmtappApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {	
			Student s1 = new Student(1, "000-61-0001", "Anna", "Lynn", "Smith", 3.45f, LocalDate.of(2019,  5, 24));
			Transcript t1 = new Transcript (1, "BS Computer Science");
			s1.setTranscript(t1);
			repository.save(t1);
			app.saveStudent(s1);
			Classroom classroom = new Classroom (1, "McLaughlin building", "M105");
			classroom.addStudents(s1);
			classRepository.save(classroom);
				
		
	}

}
