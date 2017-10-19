import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class24 {
   @ObfuscatedName("mq")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   public static final class24 field378;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   public static final class24 field369;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   public static final class24 field370;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 578711229
   )
   final int field368;
   @ObfuscatedName("o")
   final String field371;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1516003711
   )
   final int field374;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1018189985
   )
   final int field373;

   static {
      field378 = new class24("SMALL", 2, 0, 4);
      field369 = new class24("MEDIUM", 0, 1, 2);
      field370 = new class24("LARGE", 1, 2, 0);
   }

   class24(String var1, int var2, int var3, int var4) {
      this.field371 = var1;
      this.field374 = var2;
      this.field373 = var3;
      this.field368 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "-1867527939"
   )
   boolean method185(float var1) {
      return var1 >= (float)this.field368;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)[Ll;",
      garbageValue = "16"
   )
   static class24[] method179() {
      return new class24[]{field369, field378, field370};
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "723071518"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class9.font_p12full.method4839(var0, 250);
      int var6 = class9.font_p12full.method4840(var0, 250) * 13;
      Rasterizer2D.method5045(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2, 16777215);
      class9.font_p12full.method4915(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class36.method480(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var2 + var6);
      if(var1) {
         GameEngine.field733.vmethod5121(0, 0);
      } else {
         ISAACCipher.method3525(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "431624163"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "128115009"
   )
   static int method184(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 3200) {
         class278.intStackSize -= 3;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         int var5 = class81.intStack[class278.intStackSize + 2];
         if(Client.field1152 != 0 && var4 != 0 && Client.field1154 < 50) {
            Client.field1098[Client.field1154] = var3;
            Client.field1156[Client.field1154] = var4;
            Client.field1136[Client.field1154] = var5;
            Client.audioEffects[Client.field1154] = null;
            Client.field1040[Client.field1154] = 0;
            ++Client.field1154;
         }

         return 1;
      } else if(var0 == 3201) {
         class148.method2942(class81.intStack[--class278.intStackSize]);
         return 1;
      } else if(var0 == 3202) {
         class278.intStackSize -= 2;
         var3 = class81.intStack[class278.intStackSize];
         var4 = class81.intStack[class278.intStackSize + 1];
         if(Client.field1149 != 0 && var3 != -1) {
            CombatInfoListHolder.method1691(ScriptEvent.indexTrack2, var3, 0, Client.field1149, false);
            Client.field1151 = true;
         }

         return 1;
      } else {
         return 2;
      }
   }
}
