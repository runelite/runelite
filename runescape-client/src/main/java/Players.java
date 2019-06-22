import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("Players")
public class Players {
   @ObfuscatedName("q")
   @Export("__cq_q")
   static byte[] __cq_q;
   @ObfuscatedName("w")
   @Export("__cq_w")
   static byte[] __cq_w;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lgr;"
   )
   @Export("__cq_o")
   static Buffer[] __cq_o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -766468303
   )
   @Export("Players_count")
   static int Players_count;
   @ObfuscatedName("g")
   @Export("Players_indices")
   static int[] Players_indices;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 945250525
   )
   @Export("__cq_l")
   static int __cq_l;
   @ObfuscatedName("e")
   @Export("__cq_e")
   static int[] __cq_e;
   @ObfuscatedName("x")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("d")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("k")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -22568397
   )
   @Export("__cq_n")
   static int __cq_n;
   @ObfuscatedName("i")
   @Export("__cq_i")
   static int[] __cq_i;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("__cq_a")
   static Buffer __cq_a;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("NetCache_reference")
   public static Buffer NetCache_reference;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;Ljava/lang/String;)Lfx;"
   )
   public static RunException method2120(Throwable var0, String var1) {
      RunException var2;
      if(var0 instanceof RunException) {
         var2 = (RunException)var0;
         var2.string = var2.string + ' ' + var1;
      } else {
         var2 = new RunException(var0, var1);
      }

      return var2;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lfz;III)Lco;",
      garbageValue = "-1237576843"
   )
   @Export("newPcmPlayer")
   public static final PcmPlayer newPcmPlayer(TaskHandler var0, int var1, int var2) {
      if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            PcmPlayer var3 = class65.pcmPlayerProvider.player();
            var3.samples = new int[(PcmPlayer.isStereo?2:1) * 256];
            var3.frequency = var2;
            var3.init();
            var3.capacity = (var2 & -1024) + 1024;
            if(var3.capacity > 16384) {
               var3.capacity = 16384;
            }

            var3.open(var3.capacity);
            if(Login.pcmPlayerCount > 0 && Messages.soundSystem == null) {
               Messages.soundSystem = new SoundSystem();
               Friend.soundSystemExecutor = Executors.newScheduledThreadPool(1);
               Friend.soundSystemExecutor.scheduleAtFixedRate(Messages.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(Messages.soundSystem != null) {
               if(Messages.soundSystem.players[var1] != null) {
                  throw new IllegalArgumentException();
               }

               Messages.soundSystem.players[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new PcmPlayer();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "46802049"
   )
   static final void method2112(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
         if(Client.rootWidgetWidths[var4] + Client.rootWidgetXs[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetHeights[var4] + Client.rootWidgetYs[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
            Client.__client_od[var4] = true;
         }
      }

   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Lho;III)V",
      garbageValue = "-1991202495"
   )
   @Export("clickWidget")
   static final void clickWidget(Widget var0, int var1, int var2) {
      if(Client.clickedWidget == null && !Client.isMenuOpen && var0 != null && class48.method869(var0) != null) {
         Client.clickedWidget = var0;
         Client.clickedWidgetParent = class48.method869(var0);
         Client.widgetClickX = var1;
         Client.widgetClickY = var2;
         MouseRecorder.widgetDragDuration = 0;
         Client.isDraggingWidget = false;
         int var3 = Client.menuOptionsCount - 1;
         if(var3 != -1) {
            UnitPriceComparator.tempMenuAction = new MenuAction();
            UnitPriceComparator.tempMenuAction.argument1 = Client.menuArguments1[var3];
            UnitPriceComparator.tempMenuAction.argument2 = Client.menuArguments2[var3];
            UnitPriceComparator.tempMenuAction.opcode = Client.menuOpcodes[var3];
            UnitPriceComparator.tempMenuAction.argument0 = Client.menuArguments0[var3];
            UnitPriceComparator.tempMenuAction.action = Client.menuActions[var3];
         }
      }

   }

   static {
      __cq_q = new byte[2048];
      __cq_w = new byte[2048];
      __cq_o = new Buffer[2048];
      Players_count = 0;
      Players_indices = new int[2048];
      __cq_l = 0;
      __cq_e = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      __cq_n = 0;
      __cq_i = new int[2048];
      __cq_a = new Buffer(new byte[5000]);
   }
}
