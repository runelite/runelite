import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class87 {
   @ObfuscatedName("g")
   static final BigInteger field1362;
   @ObfuscatedName("m")
   static final BigInteger field1363;

   static {
      field1362 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1363 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Leo;IIII)V",
      garbageValue = "231108919"
   )
   public static final void method1653(Model var0, int var1, int var2, int var3) {
      if(class112.method2029(var0, var1, var2, var3)) {
         class7.field219.method3509(new class10(var0, var1, var2, var3, -65281));
      } else if(class7.field224 == class11.field253) {
         class7.field219.method3509(new class10(var0, var1, var2, var3, -16776961));
      }

   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(IIIILjj;Lhm;I)V",
      garbageValue = "950596493"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var8 * var3 + var9 * var2 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method4968(var10 + var5.field2569 / 2 - var4.maxWidth / 2, var5.field2566 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2569, var5.field2566, var5.field2568, var5.field2567);
            } else {
               var4.method4958(var10 + var5.field2569 / 2 + var0 - var4.maxWidth / 2, var5.field2566 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
