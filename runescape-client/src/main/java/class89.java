import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public enum class89 implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   field1405(0),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   field1404(1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   field1403(2),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   field1406(3);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 21562613
   )
   final int field1407;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("widgetIndex")
   static IndexDataBase widgetIndex;
   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static IndexData field1409;

   class89(int var3) {
      this.field1407 = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.field1407;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "29"
   )
   public static int method1732(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class211.field2596[var5 - var4];
      return class211.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lhy;IIB)Lct;",
      garbageValue = "0"
   )
   static Script method1731(class219 var0, int var1, int var2) {
      int var3 = (var1 << 8) + var0.field2788;
      Script var5 = GrandExchangeOffer.method113(var3, var0);
      if(var5 != null) {
         return var5;
      } else {
         int var4 = MouseInput.method1024(var2, var0);
         var5 = GrandExchangeOffer.method113(var4, var0);
         return var5 != null?var5:null;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "54"
   )
   static int method1733(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class278.intStackSize -= 2;
         Client.field1166 = (short)class81.intStack[class278.intStackSize];
         if(Client.field1166 <= 0) {
            Client.field1166 = 256;
         }

         Client.field1167 = (short)class81.intStack[class278.intStackSize + 1];
         if(Client.field1167 <= 0) {
            Client.field1167 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class278.intStackSize -= 2;
         Client.field993 = (short)class81.intStack[class278.intStackSize];
         if(Client.field993 <= 0) {
            Client.field993 = 256;
         }

         Client.field1147 = (short)class81.intStack[class278.intStackSize + 1];
         if(Client.field1147 <= 0) {
            Client.field1147 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class278.intStackSize -= 4;
         Client.field1003 = (short)class81.intStack[class278.intStackSize];
         if(Client.field1003 <= 0) {
            Client.field1003 = 1;
         }

         Client.field1140 = (short)class81.intStack[class278.intStackSize + 1];
         if(Client.field1140 <= 0) {
            Client.field1140 = 32767;
         } else if(Client.field1140 < Client.field1003) {
            Client.field1140 = Client.field1003;
         }

         Client.field998 = (short)class81.intStack[class278.intStackSize + 2];
         if(Client.field998 <= 0) {
            Client.field998 = 1;
         }

         Client.field1173 = (short)class81.intStack[class278.intStackSize + 3];
         if(Client.field1173 <= 0) {
            Client.field1173 = 32767;
         } else if(Client.field1173 < Client.field998) {
            Client.field1173 = Client.field998;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field1086 != null) {
            class3.method6(0, 0, Client.field1086.width, Client.field1086.height, false);
            class81.intStack[++class278.intStackSize - 1] = Client.viewportHeight;
            class81.intStack[++class278.intStackSize - 1] = Client.viewportWidth;
         } else {
            class81.intStack[++class278.intStackSize - 1] = -1;
            class81.intStack[++class278.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class81.intStack[++class278.intStackSize - 1] = Client.field993;
         class81.intStack[++class278.intStackSize - 1] = Client.field1147;
         return 1;
      } else if(var0 == 6205) {
         class81.intStack[++class278.intStackSize - 1] = Client.field1166;
         class81.intStack[++class278.intStackSize - 1] = Client.field1167;
         return 1;
      } else {
         return 2;
      }
   }
}
