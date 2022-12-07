package tn.esprit.spring.services;
import java.util.List;

import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Ville;

public interface ITrainService {
     void ajouterTrain(Train t);
     void affecterTainAVoyageur(Long   idVoyageur, Ville nomGareDepart, Ville nomGareArrivee,  double heureDepart);
     int trainPlacesLibres(Ville nomGareDepart);
     List<Train> listerTrainsIndirects(Ville nomGareDepart, Ville nomGareArrivee);
     void desaffecterVoyageursTrain(Ville nomGareDepart, Ville nomGareArrivee, double heureDepart);
     void trainsEnGare();
}
