import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class22 extends class28 {
   @ObfuscatedName("dk")
   static IndexData field336;
   @ObfuscatedName("fk")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 1882493841
   )
   static int field340;
   @ObfuscatedName("ck")
   public static char field341;

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return super.field407 == var2.field407 && var2.field406 == super.field406;
      }
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "0"
   )
   static boolean method153(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class27.method214(var0, class30.field423);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class27.method214(var3.name, class30.field423))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class27.method214(var3.previousName, class30.field423))) {
               return true;
            }
         }

         return false;
      }
   }

   public int hashCode() {
      return super.field407 | super.field406 << 8;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1002960725"
   )
   static final byte[] method158(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 >= 0 && (IndexDataBase.field3218 == 0 || var3 <= IndexDataBase.field3218)) {
         if(var2 == 0) {
            byte[] var4 = new byte[var3];
            var1.readBytes(var4, 0, var3);
            return var4;
         } else {
            int var6 = var1.readInt();
            if(var6 < 0 || IndexDataBase.field3218 != 0 && var6 > IndexDataBase.field3218) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var6];
               if(var2 == 1) {
                  class167.method3158(var5, var6, var0, var3, 9);
               } else {
                  IndexDataBase.field3215.method3127(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;B)V",
      garbageValue = "1"
   )
   void method159(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field497.field499) {
         throw new IllegalStateException("");
      } else {
         super.field410 = var2.readUnsignedByte();
         super.field408 = var2.readUnsignedByte();
         super.field409 = var2.readUnsignedShort();
         super.field404 = var2.readUnsignedShort();
         super.field407 = var2.readUnsignedShort();
         super.field406 = var2.readUnsignedShort();
         super.field408 = Math.min(super.field408, 4);
         super.field405 = new short[1][64][64];
         super.field403 = new short[super.field408][64][64];
         super.field411 = new byte[super.field408][64][64];
         super.field412 = new byte[super.field408][64][64];
         super.field413 = new class31[super.field408][64][64][];
         var3 = var1.readUnsignedByte();
         if(class35.field491.field489 != var3) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(super.field407 == var4 && super.field406 == var5) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method219(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }
}
