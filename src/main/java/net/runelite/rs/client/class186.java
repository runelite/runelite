package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
public class class186 extends class207 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -971202705
   )
   int field2991;
   @ObfuscatedName("m")
   class180 field2992;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1544617617
   )
   int field2993;
   @ObfuscatedName("l")
   class184 field2994;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1878589335
   )
   int field2995;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 589521697
   )
   int field2996;
   @ObfuscatedName("f")
   class62 field2998;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 308259321
   )
   int field2999;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 689673509
   )
   int field3000;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1248877015
   )
   int field3001;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -19518813
   )
   int field3002;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2085087873
   )
   int field3003;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -966955089
   )
   int field3004;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1376502007
   )
   int field3005;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1452373419
   )
   int field3006;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1931741973
   )
   int field3007;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1371828547
   )
   int field3008;
   @ObfuscatedName("y")
   class64 field3009;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1528498339
   )
   int field3011;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1026343887
   )
   int field3012;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1232093599
   )
   int field3014;

   @ObfuscatedName("j")
   void method3789() {
      this.field2992 = null;
      this.field2998 = null;
      this.field2994 = null;
      this.field3009 = null;
   }

   @ObfuscatedName("bl")
   static final void method3794(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field477; ++var4) {
         if(client.field484[var4] + client.field482[var4] > var0 && client.field482[var4] < var2 + var0 && client.field483[var4] + client.field526[var4] > var1 && client.field483[var4] < var1 + var3) {
            client.field370[var4] = true;
         }
      }

   }
}
