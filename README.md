# SpringHibernateSelfLearning
Notes and test projects while learning how to create a Spring MVC and Hibernate web application:

Bean Scopes

1) Singleton Bean Scope - Default Scope
	> Spring container only creates only one instance
	> Cached in memory
	> All requests for the bean wil return one shared reference to the SAME bean

	eg: 2 objects and referencing the same bean. They points to the same area of memory. Spring creates one bean and shares it with everyone who needs it.
 
2) Prototype Bean Scope
	> Will create a new object for each request.

3) How to use Beans?
	i- Load sprint container file

		> ClassPathXmlApplicationContext context = 
		new CLassPathXmlApplicationContext("applicationContext.xml");

	ii- Retrieve bean from spring container

		> Coach theCoach = context.getBean("myCoach", Coach.class);

4) Bean Lifecycle
	Container started > Bean Initialized > Dependencies Injected > Internal Spring Processing > Your Custom Init Method > Your Custom Destroy Method > Death

	Two important parts of this is:
		i- Your Custom Init Method (init-method)
		ii-Your Customer Destroy Method (destroy-method)

	> You can add custom code here and clean up handles to resources(db, sockets, files etc). These codes are called hooks.

5) Annotations of Spring Beans
	> Spring will scan Java for special annotations
		1) Enable component scanning in Spring config file
		2) Add a Spring Annotation
		3) Retrieve the Bean from the Spring Container 

	> @Component
		Spring will scan the package by using this in the applicationContext:

		 <context:component-scan base-package="com.yazid.springdemo"/>

		They are going to find the class with:

		@Component

		And automatically register this bean and they will use the bean ID of thatSillyCoach so at a later time we can retrieve that bean  from the spring container using the SpringID thatSillyCoach

[AUTOWIRING]
	> Injection FortuneService into a Coach Implementation
	> Spring will scan @Components
	> Anyone implements FortuneService Interface?
	> Inject yo!

6) Constructor Injection
	1 - Define the dependency interface and class
		a) Create the interface and a method
		b) Create the class that will use the interface
		c) Add the @Component and leave blank for autowire
		d) Import @Component library

	2 - Create a constructor in the class for injections
		a) Create a constructor in the class 
		b) Create a field (FortuneService fortuneService)
		c) In the Constructor create a function that passes the parameter of FortuneService class
		d) Add @Autowired and import library. This will autowire the 

	3 - Configure dependency injection with the @AutoWired Annotation
		a) the constructor configured with the @Autowired annotation:

			-1- @Autowired
			-2- public TennisCoach(FortuneService theFortuneService) {
			-3-
			-4- fortuneService = theFortuneService;
			-5- 
			-6- }
	
7) Setter Injection
	1 - Create setter method in class for injection
		a) setter method define:

		//define a setter injection  (InterfaceName NameToSet)
		@Autowired
		public void setFortuneService(FortuneService theFortuneService) {
			System.out.println("setFortuneService() >> I am inside");
			fortuneService = theFortuneService;
		}


	2 - Configure the dependency injection with Autowired Annotation on the Setter Method
		ps: 
		>	btw before this we set the autowire on the constructor but now we will be wiring it on the setter method

		pps: 
		>	when spring sees this Autowire and goes to inject the dependency it will say, I have a method here named X(FortuneService fortuneService). I need a component that implements the FortuneService interface.

8) Method Injection
	> We can inject dependencies by calling any method in our class

9) Field Injection (variables?)
	> Place the @Autowired directly on the field:

		@AutoWired
		private FortuneService fortuneService;

	Why do we do this?
		1) Instead on using constructor injection or setter injection we place @Autowired
		2) What happens is when Spring creates your object they will automatically set this field behind the scenes, thus not needing any setter methods.
		3) They use Java Tech called Reflection 

10) Which injection type should we use?
	> Stay consistent in your project. All is well

[Qualifying Annotation]
	> What if there are many classes implementing the same interface? How will Spring choose which class to inject?
	> Easy peasy bro:
		@Autowired
		@Qualifier("RandomFortuneService")
