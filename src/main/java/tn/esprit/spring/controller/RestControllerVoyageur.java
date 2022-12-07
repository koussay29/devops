package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.services.ITrainService;
import tn.esprit.spring.services.IVoyageService;
import tn.esprit.spring.services.IVoyageurService;

@RestController
public class RestControllerVoyageur {


    @Autowired
    IVoyageService ivoyageservice;

    @Autowired
    ITrainService itrainservice;

    @Autowired
    IVoyageurService iVoyageurservice;

    @PostMapping("/ajouterVoyage")
    @ResponseBody
    public void ajouterGare(@RequestBody Voyage voiture) {
        ivoyageservice.ajouterVoyage(voiture);
    }



    @PostMapping("/ajouterTrain")
    @ResponseBody
    public void ajouterTrain(@RequestBody Train train) {
        itrainservice.ajouterTrain(train);
    }


    @PostMapping("/ajouterVoyageur")
    @ResponseBody
    public void ajouterVoyageur(@RequestBody Voyageur voyageur) {
        iVoyageurservice.ajouterVoyageur(voyageur);
    }


    @PutMapping(value = "/affecterTrainAVoyage/{idtr}/{idvyg}")

    public void affecterTrainAVoyage(@PathVariable("idtr") Long idTrain, @PathVariable("idvyg") Long idVoyage) {
        ivoyageservice.affecterTrainAVoyage(idTrain, idVoyage);
    }



    @PutMapping(value = "/affecterTrainAVoyageur/{idc}/{nomgdpt}/{nomgarr}/{heuredept}")
    public void affecterTainAVoyageur(@PathVariable("idc") Long idVoyageur, @PathVariable("nomgdpt") Ville nomGareDepart, @PathVariable("nomgarr") Ville nomGareArrivee, @PathVariable("heuredept") double heureDepart) {
        itrainservice.affecterTainAVoyageur(idVoyageur, nomGareDepart, nomGareArrivee, heureDepart);
    }

    @GetMapping(value = "/TrainPlacesLibres/{nomgdpt}")
    public int trainPlacesLibres(@PathVariable("nomgdpt") Ville nomGareDepart) {
        System.out.println("in controller" + nomGareDepart);
        return itrainservice.trainPlacesLibres(nomGareDepart);
    }

    @GetMapping(value = "/ListerTrainsIndirects/{nomgdpt}/{nomgarr}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Train> listerTrainsIndirects(@PathVariable("nomgdpt") Ville nomGareDepart, @PathVariable("nomgarr") Ville nomGareArrivee) {
        return itrainservice.listerTrainsIndirects(nomGareDepart, nomGareArrivee);
    }

    @PutMapping(value = "/DesaffecterVoyageursTrain/{nomgdpt}/{heuredept}")
    public void desaffecterVoyageursTrain(@PathVariable("nomgdpt") Ville nomGareDepart, @PathVariable("nomgarr") Ville nomGareArrivee, @PathVariable("heuredept") double heureDepart) {
        itrainservice.desaffecterVoyageursTrain(nomGareDepart, nomGareArrivee, heureDepart);
    }

}
