package com.example.msbeton.proxy;

import com.example.msbeton.DTO.AdminDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ms-auth" , url="localhost:9090")
@LoadBalancerClient(name="ms-auth",configuration = LBConfiguration.class)
public interface Proxy {

    @GetMapping("api/auth/admin/{idAdmin}")
    AdminDTO getAdminById(@PathVariable("idAdmin") Long idAdmin);

}
