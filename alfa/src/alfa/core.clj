(ns alfa.core)

(defn lp01 [[x & xs :as col]]
  (if (empty? xs)
    x
    (lp01 xs)))

(defn testing-lp01 [col]
  (vector
    (= (last col) (lp01 col))
    (= (last []) (lp01 []))))
