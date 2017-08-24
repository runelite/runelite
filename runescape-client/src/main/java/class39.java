import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ay")
public class class39 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -241966649
   )
   public static int field551;
   @ObfuscatedName("lj")
   @ObfuscatedSignature(
      signature = "[Lhx;"
   )
   static Widget[] field549;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1484290693
   )
   static int field553;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   final class33 field546;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -160277167
   )
   public final int field543;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -121540223
   )
   int field541;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   public final Coordinates field542;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   public final Coordinates field552;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -961835033
   )
   final int field544;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1974895003
   )
   int field548;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -344128365
   )
   final int field545;

   @ObfuscatedSignature(
      signature = "(ILhs;Lhs;Laq;)V"
   )
   class39(int var1, Coordinates var2, Coordinates var3, class33 var4) {
      this.field543 = var1;
      this.field542 = var2;
      this.field552 = var3;
      this.field546 = var4;
      Area var5 = Area.field3294[this.field543];
      SpritePixels var6 = var5.method4302(false);
      if(var6 != null) {
         this.field544 = var6.width;
         this.field545 = var6.height;
      } else {
         this.field544 = 0;
         this.field545 = 0;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "17"
   )
   boolean method560(int var1, int var2) {
      Area var3 = Area.field3294[this.field543];
      switch(var3.field3309.field3542) {
      case 0:
         if(var1 >= this.field541 && var1 < this.field544 + this.field541) {
            break;
         }

         return false;
      case 1:
         if(var1 > this.field541 - this.field544 && var1 <= this.field541) {
            break;
         }

         return false;
      case 2:
         if(var1 < this.field541 - this.field544 / 2 || var1 > this.field544 / 2 + this.field541) {
            return false;
         }
      }

      switch(var3.field3312.field3276) {
      case 0:
         if(var2 > this.field548 - this.field545 && var2 <= this.field548) {
            break;
         }

         return false;
      case 1:
         if(var2 < this.field548 || var2 >= this.field545 + this.field548) {
            return false;
         }
         break;
      case 2:
         if(var2 < this.field548 - this.field545 / 2 || var2 > this.field545 / 2 + this.field548) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "184585527"
   )
   boolean method568(int var1, int var2) {
      return this.field546 == null?false:(var1 >= this.field541 - this.field546.field478 / 2 && var1 <= this.field546.field478 / 2 + this.field541?var2 >= this.field548 && var2 <= this.field546.field476 + this.field548:false);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1442044702"
   )
   boolean method559(int var1, int var2) {
      return this.method560(var1, var2)?true:this.method568(var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "502417376"
   )
   static void method573(boolean var0) {
      class91.loginMessage1 = "";
      class91.loginMessage2 = "Enter your username/email & password.";
      class91.loginMessage3 = "";
      class91.loginIndex = 2;
      if(var0) {
         class91.password = "";
      }

      if(class91.username == null || class91.username.length() <= 0) {
         if(Buffer.preferences.field1319 != null) {
            class91.username = Buffer.preferences.field1319;
            class91.field1457 = true;
         } else {
            class91.field1457 = false;
         }
      }

      class40.method575();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-636110422"
   )
   public static Class method571(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[Ljs;",
      garbageValue = "-929793904"
   )
   public static class284[] method561() {
      return new class284[]{class284.field3771, class284.field3770, class284.field3773, class284.field3772, class284.field3769};
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ILhs;ZI)V",
      garbageValue = "-2113177209"
   )
   static void method572(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class48.method767().method5184(var0);
      int var4 = Player.localPlayer.field910;
      int var5 = (Player.localPlayer.x >> 7) + class149.baseX;
      int var6 = (Player.localPlayer.y >> 7) + class67.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class48.method767().method5187(var3, var7, var1, var2);
   }
}
