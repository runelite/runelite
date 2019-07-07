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
   @Export("username")
   Username username;
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
   @Export("getUsername")
   public Username getUsername() {
      return this.username;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-60"
   )
   @Export("getName")
   public String getName() {
      return this.username == null ? "" : this.username.getName();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1204003359"
   )
   @Export("getPreviousName")
   public String getPreviousName() {
      return this.previousUsername == null ? "" : this.previousUsername.getName();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)V",
      garbageValue = "1156866388"
   )
   @Export("set")
   void set(Username username, Username previousUsername) {
      if (username == null) {
         throw new NullPointerException();
      } else {
         this.username = username;
         this.previousUsername = previousUsername;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljs;I)I",
      garbageValue = "1627362569"
   )
   @Export("compareToUser")
   public int compareToUser(User other) {
      return this.username.compareToTyped(other.username);
   }

   public int compareTo(Object var1) {
      return this.compareToUser((User)var1);
   }
}
