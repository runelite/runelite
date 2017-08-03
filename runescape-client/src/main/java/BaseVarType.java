import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("BaseVarType")
public enum BaseVarType implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   @Export("INTEGER")
   INTEGER(2, 0, Integer.class, new class2()),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   @Export("STRING")
   STRING(0, 2, String.class, new class5());

   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1685440183
   )
   final int field29;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1812606769
   )
   final int field30;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Ld;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.field29 = var3;
      this.field30 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field30;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1312276653"
   )
   protected static int method11() {
      int var0 = 0;
      if(ScriptEvent.field824 == null || !ScriptEvent.field824.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  ScriptEvent.field824 = var2;
                  GameEngine.field694 = -1L;
                  GameEngine.field693 = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if(ScriptEvent.field824 != null) {
         long var9 = BuildType.currentTimeMs();
         long var3 = ScriptEvent.field824.getCollectionTime();
         if(GameEngine.field693 != -1L) {
            long var5 = var3 - GameEngine.field693;
            long var7 = var9 - GameEngine.field694;
            if(0L != var7) {
               var0 = (int)(100L * var5 / var7);
            }
         }

         GameEngine.field693 = var3;
         GameEngine.field694 = var9;
      }

      return var0;
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-124"
   )
   static final void method12(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class18.getTileHeight(var0, var1, class8.plane) - var2;
         var0 -= class89.cameraX;
         var3 -= WallObject.cameraZ;
         var1 -= KeyFocusListener.cameraY;
         int var4 = Graphics3D.SINE[Client.cameraPitch];
         int var5 = Graphics3D.COSINE[Client.cameraPitch];
         int var6 = Graphics3D.SINE[ScriptState.cameraYaw];
         int var7 = Graphics3D.COSINE[ScriptState.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenY = var0 * Client.scale / var1 + Client.viewportHeight / 2;
            Client.screenX = var8 * Client.scale / var1 + Client.viewportWidth / 2;
         } else {
            Client.screenY = -1;
            Client.screenX = -1;
         }

      } else {
         Client.screenY = -1;
         Client.screenX = -1;
      }
   }
}
