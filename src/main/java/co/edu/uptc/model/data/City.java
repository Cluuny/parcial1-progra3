package co.edu.uptc.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {
    public String region;
    public String c_digo_dane_del_departamento;
    public String departamento;
    public String c_digo_dane_del_municipio;
    public String municipio;
}
