package com.citaexpressbk.demo.domain.dto;

import com.citaexpressbk.demo.address.DatosDireccion;
import com.citaexpressbk.demo.enums.Service;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataRegisterSupplier(//@NotBlank(message = "El nombre del usuario es obligatorio")
                                    //String nombre,
                                   //@NotBlank
                                    //@Email
                                    //String email,
                                   //@NotBlank(message = "El numero de documento es obligatorio")
                                    @Pattern(regexp = "\\d{6,12}")
                                    String nit,
                                   @NotNull
                                    @Valid
                                    DatosDireccion direccion,
                                   Boolean status,
                                   //@NotBlank
                                    //7@Pattern(regexp = "\\d{6,12}")
                                    //String telefono,
                                   @NotNull
                                   Service service) {
}
