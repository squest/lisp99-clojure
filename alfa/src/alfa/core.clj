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
