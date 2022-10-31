package com.example.mstestes.proxy;


import com.example.mstestes.DTO.AdminDTO;
import com.example.mstestes.DTO.CimentDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="ms-matieres")
@LoadBalancerClient(name="ms-matieres",configuration = LBConfiguration.class)
public interface Proxy {

    @GetMapping("/api/matieres/ciment/{idCiment}")
    CimentDTO getCimentById(@PathVariable("idCiment") Long idCiment);

    @PutMapping("/api/matieres/modifierEtatFin/{idCiment}")
    CimentDTO modifierEtatFinById(@PathVariable("idCiment") Long idCiment);

    @PutMapping("/api/matieres/modifierEtat/{idCiment}")
    CimentDTO modifierEtatById(@PathVariable("idCiment") Long idCiment);

    @GetMapping("/api/matieres/cimentExist/{idCiment}")
    boolean existsCimentByIdCiment(@PathVariable("idCiment") Long idCiment);

    @GetMapping("/api/matieres/getadmin/{idAdmin}")
    AdminDTO getAdminById(@PathVariable("idAdmin") Long idAdmin);


}
