package com.example.internship_application.service;

import com.example.internship_application.helpers.ApplicantException;
import com.example.internship_application.helpers.EmployerException;
import com.example.internship_application.helpers.JobListingException;
import com.example.internship_application.model.dto.ApplicantDto;
import com.example.internship_application.model.dto.EmployerDto;
import com.example.internship_application.model.dto.JobListingDto;
import com.example.internship_application.model.entity.Applicant;
import com.example.internship_application.model.entity.Employer;
import com.example.internship_application.model.entity.JobListing;
import com.example.internship_application.repository.ApplicantRepository;
import com.example.internship_application.repository.EmployerRepository;
import com.example.internship_application.repository.JobListingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private final ApplicantService applicantService;
    private final EmployerService employerService;
    private final JobListingService jobListingService;
    private final JobListingRepository jobListingRepository;
    private final EmployerRepository employerRepository;
    private final ApplicantRepository applicantRepository;

    public DemoService(ApplicantService applicantService, EmployerService employerService, JobListingService jobListingService, JobListingRepository jobListingRepository, EmployerRepository employerRepository, ApplicantRepository applicantRepository) {
        this.applicantService = applicantService;
        this.employerService = employerService;
        this.jobListingService = jobListingService;
        this.jobListingRepository = jobListingRepository;
        this.employerRepository = employerRepository;
        this.applicantRepository = applicantRepository;
    }

    public void init() throws JobListingException, ApplicantException, EmployerException {
        initEmployers();
        initJobs();
        initApplicants();
    }

    public List<JobListing> displayJobsByEmployer() {
        return jobListingService.getJobListingsByEmployer(1L);
    }

    public List<Applicant> displayApplicantsByEmployer() {
        return applicantService.getApplicantsByEmployer(2L);
    }

    public List<Applicant> displayApplicantsByJob() {
        return applicantService.getApplicantsByJobListing(3L);
    }

    public void deleteAJob() {
        jobListingService.deleteJobListing(4L);
    }

    public List<Employer> displayEmployers() {
        return (List<Employer>) employerRepository.findAll();
    }

    public List<JobListing> displayJobs() {
        return (List<JobListing>) jobListingRepository.findAll();
    }

    public List<Applicant> displayApplicants() {
        return (List<Applicant>) applicantRepository.findAll();
    }

    private void initEmployers() {
        EmployerDto employer1 = new EmployerDto();
        employer1.setName("SC Construct");
        employer1.setPhoneNumber("0712345678");
        employer1.setEmail("construct@build.ro");
        employer1.setAddress("Strda Traian, 14, Cluj-Napoca");
        employerService.addEmployer(employer1);

        EmployerDto employer2 = new EmployerDto();
        employer2.setName("SC BuildIT");
        employer2.setPhoneNumber("0787654321");
        employer2.setEmail("build@it.com");
        employer2.setAddress("Strda Republicii, 23, Cluj-Napoca");
        employerService.addEmployer(employer2);
    }

    private void initJobs() throws JobListingException {
        JobListingDto job1 = new JobListingDto();
        job1.setTitle("Qualified Worker");
        job1.setDatePosted("11/10/2023");
        job1.setLocation("Turda");
        job1.setDescription("We are looking for a qualified worker in handling heavy equipment.");
        job1.setEmployerId(1L);
        job1.setApplicationDeadline("27/11/2023");
        job1.setEmploymentType("Full Time");
        jobListingService.addJobListing(job1);

        JobListingDto job2 = new JobListingDto();
        job2.setTitle("Civil Engineering");
        job2.setDatePosted("7/10/2023");
        job2.setLocation("Sebes");
        job2.setDescription("We are looking for a good civil engineer.");
        job2.setEmployerId(1L);
        job2.setApplicationDeadline("20/11/2023");
        job2.setEmploymentType("Full Time");
        jobListingService.addJobListing(job2);

        JobListingDto job3 = new JobListingDto();
        job3.setTitle("Java Internship");
        job3.setDatePosted("25/09/2023");
        job3.setLocation("Cluj-Napoca");
        job3.setDescription("A good start for a Computer Science student.");
        job3.setEmployerId(2L);
        job3.setApplicationDeadline("07/10/2023");
        job3.setEmploymentType("Part Time");
        jobListingService.addJobListing(job3);

        JobListingDto job4 = new JobListingDto();
        job4.setTitle("Senior Software Engineer");
        job4.setDatePosted("01/11/2023");
        job4.setLocation("Cluj-Napoca");
        job4.setDescription("A new opportunity.");
        job4.setEmployerId(2L);
        job4.setApplicationDeadline("15/11/2023");
        job4.setEmploymentType("Full Time");
        jobListingService.addJobListing(job4);
    }

    private void initApplicants() throws ApplicantException, EmployerException {
        ApplicantDto applicant1 = new ApplicantDto();
        applicant1.setFirstName("Ion");
        applicant1.setLastName("Popescu");
        applicant1.setEmail("popion@gmail.com");
        applicant1.setPhoneNumber("0712345678");
        applicant1.setJobListingId(1L);
        applicant1.setCountry("Romania");
        applicant1.setCity("Bucuresti");
        applicant1.setAddressLine1("Strada Libertatii, Nr. 1");
        applicantService.applyForAJobListing(applicant1);

        ApplicantDto applicant2 = new ApplicantDto();
        applicant2.setFirstName("Marius");
        applicant2.setLastName("Ionescu");
        applicant2.setEmail("mar@yahoo.com");
        applicant2.setPhoneNumber("0712345678");
        applicant2.setJobListingId(1L);
        applicant2.setCountry("Romania");
        applicant2.setCity("Orsova");
        applicant2.setAddressLine1("Strada Unirii, Nr. 14");
        applicantService.applyForAJobListing(applicant2);

        ApplicantDto applicant3 = new ApplicantDto();
        applicant3.setFirstName("Angela");
        applicant3.setLastName("Marinescu");
        applicant3.setEmail("angela@gmail.com");
        applicant3.setPhoneNumber("0712345678");
        applicant3.setJobListingId(1L);
        applicant3.setCountry("Romania");
        applicant3.setCity("Oradea");
        applicant3.setAddressLine1("Strada Florilor, Nr. 5");
        applicantService.applyForAJobListing(applicant3);

        ApplicantDto applicant4 = new ApplicantDto();
        applicant4.setFirstName("John");
        applicant4.setLastName("Lenon");
        applicant4.setEmail("lenon@gmail.com");
        applicant4.setPhoneNumber("0712345678");
        applicant4.setJobListingId(1L);
        applicant4.setCountry("UK");
        applicant4.setCity("London");
        applicant4.setAddressLine1("Hemingway Street, Nr. 87");
        applicantService.applyForAJobListing(applicant4);

        ApplicantDto applicant5 = new ApplicantDto();
        applicant5.setFirstName("Ioana");
        applicant5.setLastName("Moise");
        applicant5.setEmail("moisee@domain.com");
        applicant5.setPhoneNumber("0712345678");
        applicant5.setJobListingId(1L);
        applicant5.setCountry("Romania");
        applicant5.setCity("Iasi");
        applicant5.setAddressLine1("Strada Marinei, Nr. 33");
        applicantService.applyForAJobListing(applicant5);

        ApplicantDto applicant6 = new ApplicantDto();
        applicant6.setFirstName("George");
        applicant6.setLastName("Clooney");
        applicant6.setEmail("geo@yahoo.com");
        applicant6.setPhoneNumber("0712345678");
        applicant6.setJobListingId(2L);
        applicant6.setCountry("USA");
        applicant6.setCity("New York City");
        applicant6.setAddressLine1("Washington Street, Nr. 49");
        applicantService.applyForAJobListing(applicant6);

        ApplicantDto applicant7 = new ApplicantDto();
        applicant7.setFirstName("Claudiu");
        applicant7.setLastName("Condurache");
        applicant7.setEmail("claucn@gmail.com");
        applicant7.setPhoneNumber("0712345678");
        applicant7.setJobListingId(2L);
        applicant7.setCountry("Romania");
        applicant7.setCity("Dej");
        applicant7.setAddressLine1("Strada Cosbuc, Nr. 18");
        applicantService.applyForAJobListing(applicant7);

        ApplicantDto applicant8 = new ApplicantDto();
        applicant8.setFirstName("Radu");
        applicant8.setLastName("Pop");
        applicant8.setEmail("popRadu@gmail.com");
        applicant8.setPhoneNumber("0712345678");
        applicant8.setJobListingId(2L);
        applicant8.setCountry("Romania");
        applicant8.setCity("Baia Mare");
        applicant8.setAddressLine1("Strada Eminescu, Nr. 11");
        applicantService.applyForAJobListing(applicant8);

        ApplicantDto applicant9 = new ApplicantDto();
        applicant9.setFirstName("Carla");
        applicant9.setLastName("Nazu");
        applicant9.setEmail("nazucarla@gmail.com");
        applicant9.setPhoneNumber("0712345678");
        applicant9.setJobListingId(2L);
        applicant9.setCountry("Romania");
        applicant9.setCity("Baia Sprie");
        applicant9.setAddressLine1("Strada Minerilor, Nr. 90");
        applicantService.applyForAJobListing(applicant9);

        ApplicantDto applicant10 = new ApplicantDto();
        applicant10.setFirstName("Anne");
        applicant10.setLastName("Gachou");
        applicant10.setEmail("anne@gmail.com");
        applicant10.setPhoneNumber("0712345678");
        applicant10.setJobListingId(2L);
        applicant10.setCountry("Franta");
        applicant10.setCity("Rennes");
        applicant10.setAddressLine1("Villebois Mareuil, Nr. 67");
        applicantService.applyForAJobListing(applicant10);

        ApplicantDto applicant11 = new ApplicantDto();
        applicant11.setFirstName("Camelia");
        applicant11.setLastName("Ratiu");
        applicant11.setEmail("ratiu@gmail.com");
        applicant11.setPhoneNumber("0712345678");
        applicant11.setJobListingId(3L);
        applicant11.setCountry("Romania");
        applicant11.setCity("Craiova");
        applicant11.setAddressLine1("Strada Iuliu Maniu, Nr. 112");
        applicantService.applyForAJobListing(applicant11);

        ApplicantDto applicant12 = new ApplicantDto();
        applicant12.setFirstName("Gheorghe");
        applicant12.setLastName("Patrascu");
        applicant12.setEmail("patragheo@yahoo.com");
        applicant12.setPhoneNumber("0712345678");
        applicant12.setJobListingId(3L);
        applicant12.setCountry("Romania");
        applicant12.setCity("Galati");
        applicant12.setAddressLine1("Strada Garcea, Nr. 24");
        applicantService.applyForAJobListing(applicant12);

        ApplicantDto applicant13 = new ApplicantDto();
        applicant13.setFirstName("Maria");
        applicant13.setLastName("Bob");
        applicant13.setEmail("Bob@gmail.com");
        applicant13.setPhoneNumber("0712345678");
        applicant13.setJobListingId(3L);
        applicant13.setCountry("Romania");
        applicant13.setCity("Timisoara");
        applicant13.setAddressLine1("Strada Eroilor, Nr. 51");
        applicantService.applyForAJobListing(applicant13);

        ApplicantDto applicant14 = new ApplicantDto();
        applicant14.setFirstName("Marcel");
        applicant14.setLastName("Bud");
        applicant14.setEmail("Marce@gmail.com");
        applicant14.setPhoneNumber("0712345678");
        applicant14.setJobListingId(3L);
        applicant14.setCountry("Moldova");
        applicant14.setCity("Chisinau");
        applicant14.setAddressLine1("Strada Regina Maria, Nr. 817");
        applicantService.applyForAJobListing(applicant14);

        ApplicantDto applicant15 = new ApplicantDto();
        applicant15.setFirstName("Corina");
        applicant15.setLastName("Mole");
        applicant15.setEmail("cori@domain.com");
        applicant15.setPhoneNumber("0712345678");
        applicant15.setJobListingId(3L);
        applicant15.setCountry("Germania");
        applicant15.setCity("Munchen");
        applicant15.setAddressLine1("Strada Hans-Fischer, Nr. 20");
        applicantService.applyForAJobListing(applicant15);

        ApplicantDto applicant16 = new ApplicantDto();
        applicant16.setFirstName("Samuel");
        applicant16.setLastName("Pascu");
        applicant16.setEmail("pascu@yahoo.com");
        applicant16.setPhoneNumber("0712345678");
        applicant16.setJobListingId(4L);
        applicant16.setCountry("Romania");
        applicant16.setCity("Gherla");
        applicant16.setAddressLine1("Strada Rebreanu, Nr. 19");
        applicantService.applyForAJobListing(applicant16);

        ApplicantDto applicant17 = new ApplicantDto();
        applicant17.setFirstName("Alex");
        applicant17.setLastName("Nedea");
        applicant17.setEmail("claucn@gmail.com");
        applicant17.setPhoneNumber("0712345678");
        applicant17.setJobListingId(4L);
        applicant17.setCountry("Romania");
        applicant17.setCity("Iasi");
        applicant17.setAddressLine1("Strada Cosbuc, Nr. 28");
        applicantService.applyForAJobListing(applicant17);

        ApplicantDto applicant18 = new ApplicantDto();
        applicant18.setFirstName("Alexandra");
        applicant18.setLastName("Moga");
        applicant18.setEmail("Moga@gmail.com");
        applicant18.setPhoneNumber("0712345678");
        applicant18.setJobListingId(4L);
        applicant18.setCountry("Romania");
        applicant18.setCity("Baia de Aries");
        applicant18.setAddressLine1("Strada Cetatii, Nr. 111");
        applicantService.applyForAJobListing(applicant18);

        ApplicantDto applicant19 = new ApplicantDto();
        applicant19.setFirstName("Luca");
        applicant19.setLastName("Breban");
        applicant19.setEmail("luca@gmail.com");
        applicant19.setPhoneNumber("0712345678");
        applicant19.setJobListingId(4L);
        applicant19.setCountry("Romania");
        applicant19.setCity("Deva");
        applicant19.setAddressLine1("Strada Minerilor, Nr. 910");
        applicantService.applyForAJobListing(applicant19);

        ApplicantDto applicant20 = new ApplicantDto();
        applicant20.setFirstName("Narcisa");
        applicant20.setLastName("Neagu");
        applicant20.setEmail("neagu@gmail.com");
        applicant20.setPhoneNumber("0712345678");
        applicant20.setJobListingId(4L);
        applicant20.setCountry("Romania");
        applicant20.setCity("Cluj-Napoca");
        applicant20.setAddressLine1("Strada Eroilor, Nr. 77");
        applicantService.applyForAJobListing(applicant20);
    }
}
