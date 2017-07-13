import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("cn")
public final class class82 extends Node {
   @ObfuscatedName("a")
   static Deque field1322;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -745802975
   )
   int field1318;
   @ObfuscatedName("r")
   ObjectComposition field1311;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -360253239
   )
   int field1316;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 289373315
   )
   int field1320;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -957542011
   )
   int field1317;
   @ObfuscatedName("g")
   int[] field1325;
   @ObfuscatedName("m")
   class117 field1324;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1877144855
   )
   int field1315;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1296313631
   )
   int field1313;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -119421833
   )
   int field1319;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1992664823
   )
   int field1314;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1360589833
   )
   int field1312;
   @ObfuscatedName("t")
   class117 field1321;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 154751761
   )
   int field1323;

   static {
      field1322 = new Deque();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method1576() {
      int var1 = this.field1318;
      ObjectComposition var2 = this.field1311.getImpostor();
      if(var2 != null) {
         this.field1318 = var2.ambientSoundId;
         this.field1316 = var2.field3457 * 128;
         this.field1320 = var2.field3480;
         this.field1317 = var2.field3481;
         this.field1325 = var2.field3478;
      } else {
         this.field1318 = -1;
         this.field1316 = 0;
         this.field1320 = 0;
         this.field1317 = 0;
         this.field1325 = null;
      }

      if(var1 != this.field1318 && this.field1324 != null) {
         class203.field2511.method1867(this.field1324);
         this.field1324 = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "1472042246"
   )
   static Class method1585(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "1519370723"
   )
   static long method1582(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }
}
