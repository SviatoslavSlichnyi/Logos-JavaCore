package homework.ls_13_VerhovnaRada.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerhovnaRada {

    private Map<String, Faction> factions;
    private static final VerhovnaRada INSTANCE = new VerhovnaRada();

    private VerhovnaRada() {
        factions = new HashMap<>();
    }

    public static VerhovnaRada getInstance() {
        return INSTANCE;
    }

    public void addFaction(String nameOfFaction, Faction faction) {
        factions.put(nameOfFaction, faction);
    }

    public void removeFaction(String nameOfFaction) {
        factions.remove(nameOfFaction);
    }

    public Map<String, Faction> getAllFactions() {
        return factions;
    }

    public Faction getFaction(String nameOfFaction) {
        return factions.get(nameOfFaction);
    }

    public void addDeputyToFaction(String nameOfFaction, Deputy deputy) {
        Faction faction = factions.get(nameOfFaction);
        faction.addDeputy(deputy);
    }

    public void removeDeputyFromFaction(String nameOfFaction, int id) {
        Faction faction = factions.get(nameOfFaction);
        faction.removeDeputy(id);
    }

    public List<Deputy> getAllGraftersInFaction(String nameOfFaction) {
         return factions.get(nameOfFaction).getAllGrafters();
    }

    public Deputy getBiggestGrafterInFaction(String nameOfFaction) {
        return factions.get(nameOfFaction).getBiggestGrafter();
    }

}
