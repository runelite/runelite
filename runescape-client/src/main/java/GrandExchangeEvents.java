import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
   @ObfuscatedName("i")
   public static Comparator field271;
   @ObfuscatedName("o")
   public static Comparator field267;
   @ObfuscatedName("j")
   public static Comparator field268;
   @ObfuscatedName("k")
   public static Comparator field270;
   @ObfuscatedName("p")
   public static int[] field265;
   @ObfuscatedName("jj")
   @ObfuscatedGetter(
      intValue = -1797628505
   )
   static int field266;
   @ObfuscatedName("c")
   @Export("events")
   public final List events;

   static {
      field271 = new class19();
      new WorldComparator();
      field267 = new UnitPriceComparator();
      field268 = new class18();
      field270 = new TotalQuantityComparator();
   }

   @ObfuscatedSignature(
      signature = "(Lgp;Z)V",
      garbageValue = "1"
   )
   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.events = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "65533"
   )
   @Export("sort")
   public void sort(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1113535736"
   )
   public static boolean method86(int var0) {
      return var0 >= WorldMapDecorationType.field2991.rsOrdinal && var0 <= WorldMapDecorationType.field2994.rsOrdinal;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-1007286889"
   )
   static final boolean method84(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label71:
      while(true) {
         int var6 = var4.getUSmart();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.getUSmart();
               if(var9 == 0) {
                  continue label71;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = FileRequest.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.lowMemory || var15.int1 != 0 || var15.clipType == 1 || var15.obstructsGround) {
                     if(!var15.method5003()) {
                        ++Client.field910;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.getUSmart();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }
}
