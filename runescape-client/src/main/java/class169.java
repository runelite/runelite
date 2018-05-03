import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public abstract class class169 {
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1994098663
   )
   static int field2206;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-37990145"
   )
   public abstract boolean vmethod3407(int var1) throws IOException;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1289513265"
   )
   public abstract int vmethod3406() throws IOException;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-6075"
   )
   public abstract int vmethod3405() throws IOException;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "680375269"
   )
   public abstract int vmethod3426(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1818485286"
   )
   public abstract void vmethod3411(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1579216827"
   )
   public abstract void vmethod3404();

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lhh;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1647708015"
   )
   static String method3365(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIILeb;[Lff;I)V",
      garbageValue = "-1792503626"
   )
   static final void method3364(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.getUSmart();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.getUSmart();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class62.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               WorldMapType3.addObject(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-2059313525"
   )
   static int method3352(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class49.field604:class81.field1270;
      if(var0 == 1500) {
         class81.intStack[++class171.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class81.intStack[++class171.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class81.intStack[++class171.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class81.intStack[++class171.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class81.intStack[++class171.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class81.intStack[++class171.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
