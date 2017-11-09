import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 875943395
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-1864051962"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cp")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1469273750"
   )
   protected static int method2972() {
      int var0 = 0;
      if(CombatInfoListHolder.field1280 == null || !CombatInfoListHolder.field1280.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  CombatInfoListHolder.field1280 = var2;
                  GameEngine.field694 = -1L;
                  GameEngine.field680 = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if(CombatInfoListHolder.field1280 != null) {
         long var9 = class268.currentTimeMs();
         long var3 = CombatInfoListHolder.field1280.getCollectionTime();
         if(-1L != GameEngine.field680) {
            long var5 = var3 - GameEngine.field680;
            long var7 = var9 - GameEngine.field694;
            if(0L != var7) {
               var0 = (int)(100L * var5 / var7);
            }
         }

         GameEngine.field680 = var3;
         GameEngine.field694 = var9;
      }

      return var0;
   }
}
