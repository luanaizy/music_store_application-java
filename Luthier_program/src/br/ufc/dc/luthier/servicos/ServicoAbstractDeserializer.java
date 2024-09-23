package br.ufc.dc.luthier.servicos;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class ServicoAbstractDeserializer implements JsonDeserializer<ServicoAbstract> {
	@Override
    public ServicoAbstract deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
    	
        JsonObject jsonObject = json.getAsJsonObject();
        String descricao = jsonObject.get("descricao").getAsString();
        double valor = jsonObject.get("valor").getAsDouble();

        if (jsonObject.has("peca_consertada")) {
            String pecaConsertada = jsonObject.get("peca_consertada").getAsString();
            return new ServicoManutencaoConserto(descricao, valor, pecaConsertada);
        }
        else if (jsonObject.has("regulagem_de")) {
        	String regulagem_de = jsonObject.get("regulagem_de").getAsString();
            return new ServicoManutencaoRegulagem(descricao, valor, regulagem_de);
        }
        else if (jsonObject.has("peca_antiga")) {
            String pecaAntiga = jsonObject.get("peca_antiga").getAsString();
            return new ServicoManutencaoTrocaDePeca(descricao, valor, pecaAntiga);
        }
        else if (jsonObject.has("resultado")) {
            String Resultado = jsonObject.get("resultado").getAsString();
            return new ServicoRevisao(descricao, valor, Resultado);
        }
        
        return new ServicoConstrucao(descricao, valor);
    }
}
