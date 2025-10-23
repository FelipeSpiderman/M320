package Felipe\M4\User\User.java;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user", schema = "financetracker")
class User{

    @Id
    @NotNull
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    @NotNull    
    String name;

    @NotNull
    String email;    

    @DefaultValue(false)
    Boolean admin

    public void startInteraction(){
        for(int i = 1; i == 1;){
            Scanner sc = new Scanner();
            System.out.prinln("Do you already have a profile here? (y/n) ");
            nextLine(sc.toLowercase());
            if (sc == "y"){
                loginInteraction();
               i++; 
            }else if(sc == "n"){
                registerInteraction();
                i++;
            }
            else{
                System.out.println("You didn't choose (y/n) ")
            }
        }
    }

    private void loginInteraction(){
        Scanner sc = new Scanner();
        System.out.println("Enter your name ");
        nextLine(sc);
        if(!amountUserName(sc.equals(getUserName(sc))) == 1){
            System.out.println("Please enter your email aswell, there are multiple of you");
            nextLine(sc);
            if(!sc.equals(getUserName(sc))){
                System.out.println("This email is not registered");

            }
        
        }

    }

    private void registerInteraction(){

    }
}