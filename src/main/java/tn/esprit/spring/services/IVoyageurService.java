package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Voyageur;


public interface IVoyageurService {
    void ajouterVoyageur(Voyageur voyageur);
    void modifierVoyageur(Voyageur voyageur);
    List<Voyageur> recupererAll();
    Voyageur recupererVoyageParId(long idVoyageur);
    void supprimerVoyageur(Voyageur v);
}
