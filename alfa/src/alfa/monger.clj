(ns alfa.monger
  (:require [monger.core :as mg]
            [monger.collection :as mc]))

(defonce mdb (atom {}))

(defn start-mdb [mdb-data]
  (->> #(assoc % :conn (mg/connect))
       (swap! mdb-data)))