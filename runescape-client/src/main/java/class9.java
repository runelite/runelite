import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class9 {
   @ObfuscatedName("dq")
   @Export("region")
   static Region region;
   @ObfuscatedName("v")
   static final BigInteger field154 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("jo")
   static Widget[] field158;
   @ObfuscatedName("b")
   static final BigInteger field161 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2117826248"
   )
   static final int method112() {
      if(class16.field232.field149) {
         return XItemContainer.plane;
      } else {
         int var0 = Renderable.method1960(class139.cameraX, class77.cameraY, XItemContainer.plane);
         return var0 - class172.cameraZ < 800 && (class5.tileSettings[XItemContainer.plane][class139.cameraX >> 7][class77.cameraY >> 7] & 4) != 0?XItemContainer.plane:3;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "722137374"
   )
   public static final void method114(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         class59.field1235 = var0;
         class59.field1219 = var1;
         class59.field1241 = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("e")
   static final void method115(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;Lclass187;I)Z",
      garbageValue = "-460141258"
   )
   public static boolean method116(class170 var0, class170 var1, class170 var2, class187 var3) {
      class186.field3003 = var0;
      class186.field2993 = var1;
      class186.field2994 = var2;
      class28.field670 = var3;
      return true;
   }
}
