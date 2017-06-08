import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class22 extends class28 {
   @ObfuscatedName("co")
   static IndexData field353;

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return super.field418 == var2.field418 && var2.field412 == super.field412;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;B)V",
      garbageValue = "0"
   )
   void method177(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field508.field511) {
         throw new IllegalStateException("");
      } else {
         super.field413 = var2.readUnsignedByte();
         super.field414 = var2.readUnsignedByte();
         super.field411 = var2.readUnsignedShort();
         super.field410 = var2.readUnsignedShort();
         super.field418 = var2.readUnsignedShort();
         super.field412 = var2.readUnsignedShort();
         super.field414 = Math.min(super.field414, 4);
         super.field409 = new short[1][64][64];
         super.field416 = new short[super.field414][64][64];
         super.field417 = new byte[super.field414][64][64];
         super.field420 = new byte[super.field414][64][64];
         super.field419 = new class31[super.field414][64][64][];
         var3 = var1.readUnsignedByte();
         if(class35.field504.field505 != var3) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(super.field418 == var4 && super.field412 == var5) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method237(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field418 | super.field412 << 8;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1839781258"
   )
   static final void method183(int var0) {
      if(class73.method1095(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2774 = 0;
               var3.field2662 = 0;
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "347964304"
   )
   public static boolean method188(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo2;",
      garbageValue = "954254900"
   )
   public static CombatInfo2 method189(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3365.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field3373.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method4414(new Buffer(var2));
         }

         CombatInfo2.field3365.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1796000740"
   )
   static final void method190(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class73.method1095(var0)) {
         class84.field1366 = null;
         ISAACCipher.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class84.field1366 != null) {
            ISAACCipher.gameDraw(class84.field1366, -1412584499, var1, var2, var3, var4, class163.field2323, class45.field583, var7);
            class84.field1366 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1121[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1121[var8] = true;
            }
         }

      }
   }
}
