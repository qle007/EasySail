//
//  HomeViewController.swift
//  RoomService
//
//  Created by Roy Lara on 2/3/18.
//  Copyright © 2018 Roy Lara. All rights reserved.
//

import UIKit
import Alamofire
import LoginKit

class HomeViewController: UIViewController {
    struct usermetadata {
        static let auth = ""
        static let id = ""
        static let name = ""
        static let room = ""
    }
    lazy var loginCoordinator: LoginCoordinator = {
        return LoginCoordinator(HomeViewController)
    }()
    override func viewDidLoad() {
        super.viewDidLoad()
        var resourceFileDictionary: NSDictionary?
        let storyBoard = UIStoryboard(name: "Main", Bundle: nil)
        let abcViewController = storyboard.instantiateViewControllerWithIdentifier("LoginViewController") as! LoginViewController
        abcViewController.title = "LOGIN"
        navigationController?.pushViewController(abcViewController, animated: true)
        //Load content of Info.plist into resourceFileDictionary dictionary
        if let path = Bundle.main.path(forResource: "Info", ofType: "plist") {
            resourceFileDictionary = NSDictionary(contentsOfFile: path)
        }
        
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func callRoomService(_ sender: Any) {
        if let url = URL(string: "telprompt:\(3052833697)") {
            if UIApplication.shared.canOpenURL(url) {
                UIApplication.shared.open(url)
            }
        }
    }
    func alertCleaningStaff() -> Void {
        var parameters = [String:String]()
        parameters["roomid"] = usermetadata.room
        parameters["id"] = usermetadata.id
        
        let headers: HTTPHeaders = ["Authorization": "CwsAuth service=QkZHUi9YK3ZaSHBFQ2x6ZlVUWUZ0TXNmU3dkN2c5K1g5cVFmT1hPNGtFM1RwYUNsdjZYa29IVUJ6Z01IUUxkTXgrV3pPNXJIYzZuYkwvaDFoVXp5MHJVcG9FODdEOXlJcWJtQTR0K09ncVVjSjlhTWtLV1paVjRwNlQ5QlRBalVRMERYeDlUTkRFQnA4N1dCcGhkQXhpOXBXdmpyZjdwTGlIeHRXUkNVQ0J4UDE2dXFRbmdXNVgwV0NhN2ZzS0NDZ1p1SHpGN1VFdDBJK2RxNXFDMllzTzlZTnFiN1djcVVtcEpIRXNROG9LcVUxODFxMzhtcXY0U1l2T3k0YjRPaUk5SDZCN29PS1o1bnN3NWxrSE5kVDU0YWxabUU1amxJWGgxRTVmdWpsU0NQT2dQSXV4UXJEZEduUGhKV3JVNS83K0NJbjMrOVVoZE9acDFXUjlLWlV3PT07QXV0b0JWVEtleQ==", "Accept": "application/json", "Content-Type" :"application/x-www-form-urlencoded"]
        
        Alamofire.request("https://webhooks-australiaeast-release-b.ctxwsstgapi.net/root/subscriptions", method: .post, parameters: parameters, encoding: JSONEncoding.default, headers: headers).responseJSON { response in
            
            // original URL request
            print("Request is :",response.request!)
            
            // HTTP URL response --> header and status code
            print("Response received is :",response.response!)
            
            // server data : example 267 bytes
            print("Response data is :",response.data!)
            
            // result of response serialization : SUCCESS / FAILURE
            print("Response result is :",response.result)
            
            debugPrint("Debug Print :", response)
        }
    }
    
    @IBAction func cleanOurRoom(_ sender: Any) {
        alertCleaningStaff()
    }
    
}

