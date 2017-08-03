import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public final class class10 extends class9 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 885832765
   )
   final int field249;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1689581941
   )
   final int field240;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -95628779
   )
   final int field241;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 684743171
   )
   final int field243;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 106170877
   )
   final int field242;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 468954469
   )
   final int field245;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 197575781
   )
   final int field250;

   @ObfuscatedSignature(
      signature = "(Lev;IIII)V"
   )
   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field249 = var2 + var1.field1925 - var1.field1906;
      this.field241 = var3 + var1.field1953 - var1.field1928;
      this.field242 = var4 + var1.field1926 - var1.field1929;
      this.field240 = var2 + var1.field1906 + var1.field1925;
      this.field243 = var3 + var1.field1953 + var1.field1928;
      this.field245 = var4 + var1.field1929 + var1.field1926;
      this.field250 = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1775908210"
   )
   final void vmethod55() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field249:this.field240;
         int var2 = (var4 & 2) == 0?this.field241:this.field243;
         int var3 = (var4 & 4) == 0?this.field242:this.field245;
         if((var4 & 1) == 0) {
            XGrandExchangeOffer.method113(var1, var2, var3, this.field240, var2, var3, this.field250);
         }

         if((var4 & 2) == 0) {
            XGrandExchangeOffer.method113(var1, var2, var3, var1, this.field243, var3, this.field250);
         }

         if((var4 & 4) == 0) {
            XGrandExchangeOffer.method113(var1, var2, var3, var1, var2, this.field245, this.field250);
         }
      }

   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-14"
   )
   static int method52() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;Lim;I)V",
      garbageValue = "2035834798"
   )
   public static void method54(IndexDataBase var0, IndexDataBase var1) {
      class140.field2086 = var0;
      NPCComposition.field3557 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-467691730"
   )
   static void method50() {
      class92.username = class92.username.trim();
      if(class92.username.length() == 0) {
         PendingSpawn.method1526("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class2.method3();
         int var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            var0 = Parameters.method4905(var1, class92.username);
         }

         switch(var0) {
         case 2:
            PendingSpawn.method1526("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class92.loginIndex = 6;
            break;
         case 3:
            PendingSpawn.method1526("", "Error connecting to server.", "");
            break;
         case 4:
            PendingSpawn.method1526("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            PendingSpawn.method1526("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            PendingSpawn.method1526("", "Error connecting to server.", "");
            break;
         case 7:
            PendingSpawn.method1526("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-311503497"
   )
   static final void method56(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var12 * var9 - var11 * var5 >> 16;
         var10 = var11 * var9 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var11 * var10 + var8 * var12 >> 16;
         var10 = var10 * var12 - var11 * var8 >> 16;
         var8 = var13;
      }

      class89.cameraX = var0 - var8;
      WallObject.cameraZ = var1 - var9;
      KeyFocusListener.cameraY = var2 - var10;
      Client.cameraPitch = var3;
      ScriptState.cameraYaw = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1072895559"
   )
   public static char method49(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "106"
   )
   public static int method53() {
      return ++MouseInput.mouseIdleTicks - 1;
   }
}
