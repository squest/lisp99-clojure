(ns alfa.core)

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
