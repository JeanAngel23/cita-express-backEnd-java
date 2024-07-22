package com.citaexpressbk.demo.supplier;

import com.citaexpressbk.demo.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroSupplier(@NotBlank(message = "El nombre del usuario es obligatorio")
                                    String nombre,
                                    @NotBlank
                                    @Email
                                    String email,
                                    @NotBlank(message = "El numero de documento es obligatorio")
                                    @Pattern(regexp = "\\d{6,12}")
                                    String documento,
                                    @NotNull
                                    @Valid
                                    DatosDireccion direccion,
                                    Boolean status,
                                    @NotBlank
                                    @Pattern(regexp = "\\d{6,12}")
                                    String telefono,
                                    @NotNull
                                    Service service) {
}
