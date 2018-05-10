import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class52 {
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = -1783747673
   )
   static int field476;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   final IndexData field474;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -963730673
   )
   final int field473;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -474374751
   )
   int field475;

   @ObfuscatedSignature(
      signature = "(Lic;Ljava/lang/String;)V"
   )
   class52(IndexData var1, String var2) {
      this.field475 = 0;
      this.field474 = var1;
      this.field473 = var1.size();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-107"
   )
   boolean method1065() {
      this.field475 = 0;

      for(int var1 = 0; var1 < this.field473; ++var1) {
         if(!this.field474.method4745(var1) || this.field474.method4744(var1)) {
            ++this.field475;
         }
      }

      return this.field475 >= this.field473;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "-1399125379"
   )
   public static char method1068(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class301.cp1252AsciiExtension[var1 - 128];
            if(var2 == 0) {
               var2 = '?';
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "135918739"
   )
   static int method1066(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class184.field2379:FriendManager.field996;
      if(var0 == 1600) {
         class69.intStack[++class45.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class69.intStack[++class45.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class69.intStack[++class45.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class69.intStack[++class45.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class69.intStack[++class45.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         class69.intStack[++class45.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class69.intStack[++class45.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class69.intStack[++class45.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class69.intStack[++class45.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class69.intStack[++class45.intStackSize - 1] = var3.field2649;
         return 1;
      } else if(var0 == 1611) {
         class69.intStack[++class45.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class69.intStack[++class45.intStackSize - 1] = var3.field2640;
         return 1;
      } else if(var0 == 1613) {
         class69.intStack[++class45.intStackSize - 1] = var3.field2700.rsOrdinal();
         return 1;
      } else if(var0 == 1614) {
         class69.intStack[++class45.intStackSize - 1] = var3.field2679?1:0;
         return 1;
      } else {
         return 2;
      }
   }
}
