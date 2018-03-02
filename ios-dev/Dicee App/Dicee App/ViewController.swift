//
//  ViewController.swift
//  Dicee App
//
//  Created by Paulo Alves on 02/03/2018.
//  Copyright © 2018 Paulo Alves. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    let dices = ["dice1", "dice2", "dice3", "dice4", "dice5", "dice6"]
    
    @IBOutlet weak var diceLeftImageView: UIImageView!
    @IBOutlet weak var diceRightImageView: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        rollDices()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func rollButtonPressed(_ sender: UIButton) {
        rollDices()
    }
    
    func rollDices() {
        diceLeftImageView.image = UIImage(named: dices[
            Int(arc4random_uniform(6))
        ])
        
        diceRightImageView.image = UIImage(named: dices[
            Int(arc4random_uniform(6))
        ])
    }
    
    override func motionEnded(_ motion: UIEventSubtype, with event: UIEvent?) {
        rollDices()
    }
    
}

