import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("User")
public class User implements Comparable {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("username0")
   Username username0;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("previousUsername")
   Username previousUsername;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lkp;",
      garbageValue = "1922393088"
   )
   @Export("username")
   public Username username() {
      return this.username0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-60"
   )
   @Export("name")
   public String name() {
      return this.username0 == null?"":this.username0.getName();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1204003359"
   )
   @Export("previousName")
   public String previousName() {
      return this.previousUsername == null?"":this.previousUsername.getName();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)V",
      garbageValue = "1156866388"
   )
   @Export("set")
   void set(Username var1, Username var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.username0 = var1;
         this.previousUsername = var2;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljs;I)I",
      garbageValue = "1627362569"
   )
   @Export("compareTo0")
   public int compareTo0(User var1) {
      return this.username0.compareTo0(var1.username0);
   }

   @Export("compareTo")
   @ObfuscatedName("compareTo")
   public int compareTo(Object var1) {
      return this.compareTo0((User)var1);
   }
}
