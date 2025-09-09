    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/public/**").permitAll()
                    .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()); // Or configure explicitly
            return http.build();
        }
    }
