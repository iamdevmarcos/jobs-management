package com.iamdevmarcos.jobs_management.modules.company.useCases;

import javax.naming.AuthenticationException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.iamdevmarcos.jobs_management.modules.company.dto.AuthCompanyDTO;
import com.iamdevmarcos.jobs_management.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthCompanyUseCase {
    @Value("${security.token.secret}")
    private String secretKey;

    @Value("${security.token.issuer}")
    private String tokenIssuer;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository.findByCompanyUsername(authCompanyDTO.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("Company not found")
        );

        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getCompanyPassword());
        if(!passwordMatches) {
            throw new javax.naming.AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.create()
            .withIssuer(tokenIssuer)
            .withSubject(company.getCompanyId().toString())
            .sign(algorithm);
    }
}
