(ns alfa.core
  (:require [clojure.set :as cset]))

(defn lp01 [[x & xs :as col]]
  (if (empty? xs)
    x
    (lp01 xs)))

(defn testing-lp01 [col]
  (vector
    (= (last col) (lp01 col))
    (= (last []) (lp01 []))))

(defn split-at' [n col]
  (loop [i 0 [x & xs :as c] col res []]
    (if (= n i)
      [res (vec c)]
      (recur (inc i) xs (conj res x)))))

(defn partition' [n col]
  (loop [i 1 [x & xs :as c] col res [] resi []]
    (if (empty? c)
      (if (= n (count resi))
        (conj res resi)
        res)
      (if (= i n)
        (recur 1 xs (conj res (conj resi x)) [])
        (recur (inc i) xs res (conj resi x))))))

(defn partition-all' [n col]
  (loop [[x & xs :as c] col res [] resi []]
    (if (empty? c)
      (conj res resi)
      (if (= (count resi) n)
        (recur xs (conj res resi) [x])
        (recur xs res (conj resi x))))))

(defn partition'' [n col]
  (loop [[x & xs :as c] col res [] resi []]
    (if (< (+ (count resi) (count c)) n)
      (seq res)
      (if (= n (count resi))
        (recur xs (conj res (seq resi)) [x])
        (recur xs res (conj resi x))))))

(defn factors [p]
  (filter #(= 0 (rem p %)) (range 1 (inc p))))

(defn gcd [col]
  (->> (map factors col)
       (map set)
       (apply cset/intersection)
       vec
       sort
       last))

(defn factors-loop [p]
  (loop [i 1 res []]
    (if (> i p)
      res
      (if (= 0 (rem p i))
        (recur (inc i) (conj res i))
        (recur (inc i) res)))))








