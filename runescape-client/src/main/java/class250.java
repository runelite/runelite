import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public class class250 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3369;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static NodeCache field3367;
   @ObfuscatedName("r")
   public boolean field3368;

   static {
      field3367 = new NodeCache(64);
   }

   class250() {
      this.field3368 = false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "-141002358"
   )
   void method4302(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4294(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;IB)V",
      garbageValue = "62"
   )
   void method4294(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3368 = true;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1035781250"
   )
   static final boolean method4301(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1608865957"
   )
   protected static int method4295() {
      int var0 = 0;
      if(class272.field3708 == null || !class272.field3708.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  class272.field3708 = var2;
                  GameEngine.field672 = -1L;
                  GameEngine.field671 = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if(class272.field3708 != null) {
         long var9 = ChatLineBuffer.currentTimeMs();
         long var3 = class272.field3708.getCollectionTime();
         if(-1L != GameEngine.field671) {
            long var5 = var3 - GameEngine.field671;
            long var7 = var9 - GameEngine.field672;
            if(0L != var7) {
               var0 = (int)(100L * var5 / var7);
            }
         }

         GameEngine.field671 = var3;
         GameEngine.field672 = var9;
      }

      return var0;
   }
}
