import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("cf")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1687024417
   )
   @Export("sampleRate")
   public static int sampleRate;
   @ObfuscatedName("aj")
   static int[] field1271;
   @ObfuscatedName("nu")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 962957781
   )
   int field1276;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1960149811
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1645721651
   )
   @Export("health")
   int health;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1062760405
   )
   int field1277;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1276 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1277 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-846597884"
   )
   void method1499(int var1, int var2, int var3, int var4) {
      this.field1276 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1277 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;I)I",
      garbageValue = "-920862443"
   )
   static int method1503(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.method4028("title.jpg", "")) {
         ++var2;
      }

      if(var1.method4028("logo", "")) {
         ++var2;
      }

      if(var1.method4028("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method4028("titlebox", "")) {
         ++var2;
      }

      if(var1.method4028("titlebutton", "")) {
         ++var2;
      }

      if(var1.method4028("runes", "")) {
         ++var2;
      }

      if(var1.method4028("title_mute", "")) {
         ++var2;
      }

      if(var1.method4028("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.method4028("options_radio_buttons,2", "")) {
         ++var2;
      }

      var1.method4028("sl_back", "");
      var1.method4028("sl_flags", "");
      var1.method4028("sl_arrows", "");
      var1.method4028("sl_stars", "");
      var1.method4028("sl_button", "");
      return var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Ljb;",
      garbageValue = "1322565577"
   )
   public static class276 method1505(int var0) {
      class276[] var1 = new class276[]{class276.field3720, class276.field3719, class276.field3718};
      class276[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class276 var4 = var2[var3];
         if(var0 == var4.field3721) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "938418023"
   )
   static Class method1498(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-1319618089"
   )
   static int method1504(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class83.intStack[--BufferProvider.intStackSize];
         var4 = class239.method4167(var3);
      } else {
         var4 = var2?class48.field614:FaceNormal.field2099;
      }

      if(var0 == 1000) {
         BufferProvider.intStackSize -= 4;
         var4.originalX = class83.intStack[BufferProvider.intStackSize];
         var4.originalY = class83.intStack[BufferProvider.intStackSize + 1];
         var4.field2714 = class83.intStack[BufferProvider.intStackSize + 2];
         var4.field2623 = class83.intStack[BufferProvider.intStackSize + 3];
         class21.method156(var4);
         CombatInfoListHolder.clientInstance.method1252(var4);
         if(var3 != -1 && var4.type == 0) {
            class77.method1465(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         BufferProvider.intStackSize -= 4;
         var4.originalWidth = class83.intStack[BufferProvider.intStackSize];
         var4.field2629 = class83.intStack[BufferProvider.intStackSize + 1];
         var4.field2624 = class83.intStack[BufferProvider.intStackSize + 2];
         var4.buttonType = class83.intStack[BufferProvider.intStackSize + 3];
         class21.method156(var4);
         CombatInfoListHolder.clientInstance.method1252(var4);
         if(var3 != -1 && var4.type == 0) {
            class77.method1465(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class83.intStack[--BufferProvider.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class21.method156(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2750 = class83.intStack[--BufferProvider.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2751 = class83.intStack[--BufferProvider.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
