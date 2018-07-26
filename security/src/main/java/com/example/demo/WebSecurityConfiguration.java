package com.example.demo;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/18
 * @CopyRight: lengbar.cn
 */
//@Configuration
//@EnableWebFluxSecurity
//@EnableGlobalAuthentication
//@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
//
////    @Autowired
////    private MyUserDetailService userDetailService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic().and().csrf()
////                .disable();
////        http.authorizeRequests()
////                .antMatchers("/**").access("hasRole('user')")
////                .anyRequest().authenticated().and()
////                .formLogin().and().httpBasic();
//        super.configure(http);
//    }
//
////    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("username").password(new BCryptPasswordEncoder().encode("password")).roles("ADMIN")
//                .and()
//                .withUser("123456").password(new BCryptPasswordEncoder().encode("123456")).roles("user","solace");
//
//        ;
//    }

//    @Bean
//    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();
//    }
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    @Primary
//    public DefaultTokenServices tokenServices() {
//        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//        defaultTokenServices.setTokenStore(tokenStore());
//        defaultTokenServices.setSupportRefreshToken(true);
//        defaultTokenServices.setAccessTokenValiditySeconds(5000);
//        defaultTokenServices.setRefreshTokenValiditySeconds(5000);
//        return defaultTokenServices;
//    }
//
//    @Bean
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }


//}
