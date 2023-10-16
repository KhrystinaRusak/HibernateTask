public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            Configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Student.class);
            configuration.configure("hibernate.cfg.xml");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        } catch (Trowable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        public static SessionFactory getSessionFactory() {
            if(sessionFactory == null) {
                sessionFactory = buildSessionFactory();
            }
            return sessionFactory;
        }
    }
}