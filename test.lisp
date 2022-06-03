(setq a 29)
(setq b (+ a 13))
b

((lambda () 42))
((lambda (x) (+ (* x 0) 42)) 2)
((lambda (x y) (+ (+ (* x 0) (* y 0)) 42)) 2 3)

(setq zero (lambda () 42))
(setq one (lambda (x) (+ (* x 0) 42)))
(setq two (lambda (x y) (+ (+ (* x 0) (* y 0)) 42)))

(setq safeTable (list (list 13 30 30) (list 6 30 10) (list 27 30 50) (list 13 15 50) (list 13 120 10) (list 27 120 30) (list 6 15 30)))

(setq threeIsEqual (lambda (x y z f g h) (and (and (= x f) (= y g)) (= z h))))

(setq listDerivedSafe 
  (lambda (dis dur exh) (or (and (and (= dis 13) (= dur 30)) (= exh 30)) (or (and (and (= dis 6) (= dur 30)) (= exh 10)) (or (and (and (= dis 27) (= dur 30)) (= exh 50)) (or (and (and (= dis 13) (= dur 15)) (= exh 50)) (or (and (and (= dis 13) (= dur 120)) (= exh 10)) (or (and (and (= dis 27) (= dur 120)) (= exh 30)) (and (and (= dis 6) (= dur 15)) (= exh 30))))))))
    ))